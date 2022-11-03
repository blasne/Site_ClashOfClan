package api;

import java.io.IOException;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import exception.AccessDeniedException;
import exception.ClashOfClansApiException;
import exception.ProvidedIncorrectParametersException;
import exception.RequestThrottledException;
import exception.ResourceNotFoundException;
import exception.ServiceTemprorarilyException;
import exception.UnknownErrorHappenedException;
import model.clan.ClanInfo;
import model.clan.ClanMembers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
  * General class for controlling all Clash Of Clans API functional
 */
public class ClashAPI {
    private final String API_KEY;
    private final OkHttpClient CLIENT = new OkHttpClient();

    private final String HOST, API_VERSION;

   /**
    * @param apiToken the copied Clash of Clans API from site
 * @throws ServiceTemprorarilyException 
 * @throws UnknownErrorHappenedException 
 * @throws ResourceNotFoundException 
 * @throws AccessDeniedException 
    */
    public ClashAPI(String apiToken) throws AccessDeniedException, ResourceNotFoundException, UnknownErrorHappenedException, ServiceTemprorarilyException {
        this.API_KEY = apiToken;
        this.HOST = "https://api.clashofclans.com";
        this.API_VERSION = "v1";

        if(!check())
        	throw new AccessDeniedException("Check result is not normal. Check the internet connection or the correctness of the api token.");
    }

   /**
    * @param apiToken the copied Clash of Clans API from site
    * @param apiHost the api host
    * @param apiVersion the api version
    */
    @Deprecated
    public ClashAPI(String apiToken, String apiHost, String apiVersion) {
        this.API_KEY = apiToken;
        this.HOST = apiHost;
        this.API_VERSION = apiVersion;
    }

    @NotNull
    private static String formatTag(@NotNull String copiedTag) {
        if(copiedTag.toCharArray()[0] == '#') return copiedTag.replace("#", "%23");
        else return "%23" + copiedTag;
    }

    @Nullable
    private static Response checkResponse(@NotNull Response response) throws ClashOfClansApiException, ResourceNotFoundException, UnknownErrorHappenedException, ServiceTemprorarilyException {
        if(response.isSuccessful()) return response;

        String incorrectParameterExceptionText = "not found";

        try {
        	incorrectParameterExceptionText.equals(response.body().string());
        }
        catch(IOException ignored) {
        	
        }

        switch(response.code()) {
//            case 400: throw new ProvidedIncorrectParametersException(GSON.fromJson(incorrectParameterExceptionText, ProvidedIncorrectParametersException.class).message);
            case 403: throw new AccessDeniedException();
            case 404: throw new ResourceNotFoundException();
            case 429: throw new RequestThrottledException();
            case 500: throw new UnknownErrorHappenedException();
            case 503: throw new ServiceTemprorarilyException();
        }

        return null;
    }

    /**
     * @param other the other parameters for https request.
     * @return request body
     * @throws ServiceTemprorarilyException 
     * @throws UnknownErrorHappenedException 
     * @throws ResourceNotFoundException 
     * @throws ClashOfClansApiException 
     */
    public String get(String other) throws ClashOfClansApiException, ResourceNotFoundException, UnknownErrorHappenedException, ServiceTemprorarilyException {
    	// Creation de la requete
        Request request = new Request.Builder()
                .header("authorization", "Bearer [api_key]".replace("[api_key]", API_KEY))
                .url("[host]/[version]/[other]"
                        .replace("[host]", HOST)
                        .replace("[version]", API_VERSION)
                        .replace("[other]", other))
                .build();

        // Recuperation de la reponse
        try(Response response = CLIENT.newCall(request).execute()) {
        	// Verification de la reponse
            Response verifiedResponse = checkResponse(response);
            
            if(verifiedResponse != null) {
            	// Reponse correcte
            	return verifiedResponse.body().string();
            }

        }
        catch(IOException ioException) {
        	ioException.printStackTrace();
        }

        return null;
    }

     /**
      * The method makes a normal https request to the server API to check the status.
      * @return status
     * @throws ServiceTemprorarilyException 
     * @throws UnknownErrorHappenedException 
     * @throws ResourceNotFoundException 
      */
    public boolean check() throws ResourceNotFoundException, UnknownErrorHappenedException, ServiceTemprorarilyException {
        try { 
        	get("goldpass/seasons/current"); 
        } 
        catch(ClashOfClansApiException clashOfClansApiException) {
        	return false;
        }
        return true;
    }

//     /**
//      * @param playerTag the player tag
//      * @return player object
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//    public Player getPlayerStats(String playerTag) throws ClashOfClansApiException {
//        String responseBodyString = get("players/[tag]".replace("[tag]", formatTag(playerTag)));
//        return GSON.fromJson(responseBodyString, Player.class);
//    }
//
//     /**
//      * @return gold pass object
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//    public CurrentGoldPass getCurrentGoldPass() throws ClashOfClansApiException {
//        return GSON.fromJson(get("goldpass/seasons/current"), CurrentGoldPass.class);
//    }
//
//     /**
//      * @return label objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//    public List<GeneralLabels.Item> getLabels() throws ClashOfClansApiException {
//        return GSON.fromJson(get("labels/clans"), GeneralLabels.class).items;
//    }
//
//     /**
//      * @param limit the getting limit
//      * @return label objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//     public List<GeneralLabels.Item> getLabels(int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("labels/clans?limit=[limit]".replace("[limit]", String.valueOf(limit))), GeneralLabels.class).items;
//     }
//
//     /**
//      * @return location objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//     public List<Location.Item> getLocations() throws ClashOfClansApiException {
//        return GSON.fromJson(get("locations"), Location.class).items;
//     }
//
//     /**
//      * @param limit the getting limit
//      * @return location objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//     public List<Location.Item> getLocations(int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("locations?limit=[limit]".replace("[limit]", String.valueOf(limit))), Location.class).items;
//     }
//
//     /**
//      * @param locationId the location id
//      * @return location object
//      * @throws ClashOfClansApiException is generated if location not found or other request errors
//      */
//    public OneLocation getLocationById(Long locationId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("locations/" + locationId.toString()), OneLocation.class);
//    }
//
//     /**
//      * @param locationId the location id
//      * @return ranking player objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//    public List<RankingsPlayersVersus.Item> getRankingsPlayersVersus(Long locationId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("locations/[id]/rankings/players-versus".replace("[id]", locationId.toString())),
//                RankingsPlayersVersus.class).items;
//    }
//
//     /**
//      * @param locationId the location id
//      * @param limit the getting limit
//      * @return ranking player objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//     public List<RankingsPlayersVersus.Item> getRankingsPlayersVersus(Long locationId, int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("locations/[id]/rankings/players-versus?limit=[limit]".replace("[id]", locationId.toString()).replace("[limit]", String.valueOf(limit))),
//                 RankingsPlayersVersus.class).items;
//     }
//
//     /**
//      * @param locationId the location id
//      * @return ranking versus clan objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//    public List<RankingsClansVersus.Item> getRankingsClanVersus(Long locationId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("locations/[location]/rankings/clans-versus".replace("[location]", locationId.toString())), RankingsClansVersus.class).items;
//    }
//
//     /**
//      * @param locationId the location id
//      * @param limit the getting limit
//      * @return ranking versus clan objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//     public List<RankingsClansVersus.Item> getRankingsClanVersus(Long locationId, int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("locations/[location]/rankings/clans-versus?limit=[limit]"
//                 .replace("[location]", locationId.toString())
//                 .replace("[limit]", String.valueOf(limit))), RankingsClansVersus.class).items;
//     }
//
//     /**
//      * @param locationId the location id
//      * @return ranking player objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//    public List<RankingsPlayers.Item> getRankingPlayers(Long locationId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("locations/[location]/rankings/players".replace("[location]", locationId.toString())), RankingsPlayers.class).items;
//    }
//
//     /**
//      * @param locationId the location id
//      * @param limit the getting limit
//      * @return ranking player objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//     public List<RankingsPlayers.Item> getRankingPlayers(Long locationId, int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("locations/[location]/rankings/players?limit=[limit]"
//                 .replace("[location]", locationId.toString())
//                 .replace("[limit]", String.valueOf(limit))), RankingsPlayers.class).items;
//     }
//
//     /**
//      * @param locationId the location id
//      * @return ranking clan objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//    public List<RankingsClans.Item> getRankingClans(Long locationId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("locations/[location]/rankings/clans".replace("[location]", locationId.toString())), RankingsClans.class).items;
//    }
//
//     /**
//      * @param locationId the location id
//      * @param limit getting limit
//      * @return ranking clan objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//     public List<RankingsClans.Item> getRankingClans(Long locationId, int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("locations/[location]/rankings/clans?limit=[limit]"
//                 .replace("[location]", locationId.toString())
//                 .replace("[limit]", String.valueOf(limit))), RankingsClans.class).items;
//     }
//
//     /**
//      * @return league objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//    public List<Leagues.Item> getLeagues() throws ClashOfClansApiException {
//        return GSON.fromJson(get("leagues"), Leagues.class).items;
//    }
//
//     /**
//      * @param limit the getting limit
//      * @return league objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//     public List<Leagues.Item> getLeagues(int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("leagues?limit=[limit]".replace("[limit]", String.valueOf(limit))), Leagues.class).items;
//     }
//
//     /**
//      * Not recommended for use, although the api allows you to specify any league identifier, only one is valid anyway, otherwise, when you specify another league, an error will be generated
//      * @param leagueId the league id
//      * @return league object list
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//    @Deprecated
//    public List<LeagueSeason.Item> getLeagueSeasons(Long leagueId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("leagues/[id]/seasons".replace("[id]", leagueId.toString())), LeagueSeason.class).items;
//    }
//
//     /**
//      * Not recommended for use, although the api allows you to specify any league identifier, only one is valid anyway, otherwise, when you specify another league, an error will be generated
//      * @param leagueId the league id
//      * @param limit the getting limit
//      * @return league objects list
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//     @Deprecated
//     public List<LeagueSeason.Item> getLeagueSeasons(Long leagueId, int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("leagues/[id]/seasons?limit=[limit]"
//                 .replace("[id]", leagueId.toString())
//                 .replace("[limit]", String.valueOf(limit))), LeagueSeason.class).items;
//     }
//
//     /**
//      * @return league season objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//    public List<LeagueSeason.Item> getLeagueSeasons() throws ClashOfClansApiException {
//        return getLeagueSeasons(29000022L);
//    }
//
//     /**
//      * @param limit the getting limit
//      * @return league season objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//     public List<LeagueSeason.Item> getLeagueSeasons(int limit) throws ClashOfClansApiException {
//         return getLeagueSeasons(29000022L, limit);
//     }
//
//     /**
//      * @param leagueId the league id
//      * @return league season object
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//    public LeagueSeason.Item getLeagueInfo(Long leagueId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("leagues/[id]".replace("[id]", leagueId.toString())), LeagueSeason.Item.class);
//    }
//
//     /**
//      * @return war league objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//    public List<WarLeague.Item> getWarLeagues() throws ClashOfClansApiException {
//        return GSON.fromJson(get("warleagues"), WarLeague.class).items;
//    }
//
//     /**
//      * @param limit the getting limit
//      * @return wae league objects
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//     public List<WarLeague.Item> getWarLeagues(int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("warleagues?limit=[limit]".replace("[limit]", String.valueOf(limit))), WarLeague.class).items;
//     }
//
//     /**
//      * @param warLeagueId the war league id
//      * @return war league object
//      * @throws ClashOfClansApiException is generated if request code equals critical
//      */
//    public WarLeague.Item getWarLeagueInfo(@NotNull Long warLeagueId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("warleagues/[id]".replace("[id]", warLeagueId.toString())), WarLeague.Item.class);
//    }
//
     /**
      * @param clanTag the clan tag
      * @return clan members
      * @throws ClashOfClansApiException is generated if request code equals critical
      */
    public ClanMembers getClanMembers(String clanTag) throws ClashOfClansApiException {
    	ObjectMapper objectMapper = new ObjectMapper();
    	ClanMembers ci;
		try {
			ci = objectMapper.readValue(get("clans/[tag]/members".replace("[tag]", formatTag(clanTag))), ClanMembers.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownErrorHappenedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceTemprorarilyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClashOfClansApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ci;
    }

     /**
      * @param clanTag the clan tag
      * @param limit the getting limit
      * @return clan members
      * @throws ClashOfClansApiException is generated if request code equals critical
      */
     public ClanMembers getClanMembers(String clanTag, int limit) throws ClashOfClansApiException {
     	ObjectMapper objectMapper = new ObjectMapper();
     	ClanMembers ci;
		try {
			ci = objectMapper.readValue(get("clans/[tag]/members?limit=[limit]"
			        .replace("[tag]", formatTag(clanTag))
			        .replace("[limit]", String.valueOf(limit))), ClanMembers.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownErrorHappenedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceTemprorarilyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClashOfClansApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return ci;
     }

     /**
      * @param clanTag the clan tag
      * @return clan information
      * @throws ClashOfClansApiException is generated if request code equals critical
     * @throws JsonProcessingException 
     * @throws JsonMappingException 
      */
    public ClanInfo getClanInfo(String clanTag) throws ClashOfClansApiException, JsonMappingException, JsonProcessingException {
    	ObjectMapper objectMapper = new ObjectMapper();
    	ClanInfo ci = objectMapper.readValue(get("clans/[tag]".replace("[tag]", formatTag(clanTag))), ClanInfo.class);
        return ci;
    }
}