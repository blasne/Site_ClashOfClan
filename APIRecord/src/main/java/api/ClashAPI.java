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
import model.clan.CapitalRaidSeasons;
import model.clan.ClanInfo;
import model.clan.ClanMembers;
import model.clan.CurrentWar;
import model.clan.Player;
import model.clan.WarLog;
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
    public ClashAPI(String apiToken) {
        this.API_KEY = apiToken;
        this.HOST = "https://api.clashofclans.com";
        this.API_VERSION = "v1";

        try {
			if(!check())
				throw new AccessDeniedException("Check result is not normal. Check the internet connection or the correctness of the api token.");
		} catch (ResourceNotFoundException | UnknownErrorHappenedException | ServiceTemprorarilyException
				| AccessDeniedException e) {
			e.printStackTrace();
		}
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

//    public Player getPlayerStats(String playerTag) throws ClashOfClansApiException {
//        String responseBodyString = get("players/[tag]".replace("[tag]", formatTag(playerTag)));
//        return GSON.fromJson(responseBodyString, Player.class);
//    }
//
//    public CurrentGoldPass getCurrentGoldPass() throws ClashOfClansApiException {
//        return GSON.fromJson(get("goldpass/seasons/current"), CurrentGoldPass.class);
//    }
//
//    public List<GeneralLabels.Item> getLabels() throws ClashOfClansApiException {
//        return GSON.fromJson(get("labels/clans"), GeneralLabels.class).items;
//    }
//
//     public List<GeneralLabels.Item> getLabels(int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("labels/clans?limit=[limit]".replace("[limit]", String.valueOf(limit))), GeneralLabels.class).items;
//     }
//
//     public List<Location.Item> getLocations() throws ClashOfClansApiException {
//        return GSON.fromJson(get("locations"), Location.class).items;
//     }
//
//     public List<Location.Item> getLocations(int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("locations?limit=[limit]".replace("[limit]", String.valueOf(limit))), Location.class).items;
//     }
//
//    public OneLocation getLocationById(Long locationId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("locations/" + locationId.toString()), OneLocation.class);
//    }
//
//    public List<RankingsPlayersVersus.Item> getRankingsPlayersVersus(Long locationId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("locations/[id]/rankings/players-versus".replace("[id]", locationId.toString())),
//                RankingsPlayersVersus.class).items;
//    }
//
//     public List<RankingsPlayersVersus.Item> getRankingsPlayersVersus(Long locationId, int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("locations/[id]/rankings/players-versus?limit=[limit]".replace("[id]", locationId.toString()).replace("[limit]", String.valueOf(limit))),
//                 RankingsPlayersVersus.class).items;
//     }
//
//    public List<RankingsClansVersus.Item> getRankingsClanVersus(Long locationId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("locations/[location]/rankings/clans-versus".replace("[location]", locationId.toString())), RankingsClansVersus.class).items;
//    }
//
//     public List<RankingsClansVersus.Item> getRankingsClanVersus(Long locationId, int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("locations/[location]/rankings/clans-versus?limit=[limit]"
//                 .replace("[location]", locationId.toString())
//                 .replace("[limit]", String.valueOf(limit))), RankingsClansVersus.class).items;
//     }
//
//    public List<RankingsPlayers.Item> getRankingPlayers(Long locationId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("locations/[location]/rankings/players".replace("[location]", locationId.toString())), RankingsPlayers.class).items;
//    }
//
//     public List<RankingsPlayers.Item> getRankingPlayers(Long locationId, int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("locations/[location]/rankings/players?limit=[limit]"
//                 .replace("[location]", locationId.toString())
//                 .replace("[limit]", String.valueOf(limit))), RankingsPlayers.class).items;
//     }
//
//    public List<RankingsClans.Item> getRankingClans(Long locationId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("locations/[location]/rankings/clans".replace("[location]", locationId.toString())), RankingsClans.class).items;
//    }
//
//     public List<RankingsClans.Item> getRankingClans(Long locationId, int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("locations/[location]/rankings/clans?limit=[limit]"
//                 .replace("[location]", locationId.toString())
//                 .replace("[limit]", String.valueOf(limit))), RankingsClans.class).items;
//     }
//
//    public List<Leagues.Item> getLeagues() throws ClashOfClansApiException {
//        return GSON.fromJson(get("leagues"), Leagues.class).items;
//    }
//
//     public List<Leagues.Item> getLeagues(int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("leagues?limit=[limit]".replace("[limit]", String.valueOf(limit))), Leagues.class).items;
//     }
//
//    @Deprecated
//    public List<LeagueSeason.Item> getLeagueSeasons(Long leagueId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("leagues/[id]/seasons".replace("[id]", leagueId.toString())), LeagueSeason.class).items;
//    }
//
//     @Deprecated
//     public List<LeagueSeason.Item> getLeagueSeasons(Long leagueId, int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("leagues/[id]/seasons?limit=[limit]"
//                 .replace("[id]", leagueId.toString())
//                 .replace("[limit]", String.valueOf(limit))), LeagueSeason.class).items;
//     }
//
//    public List<LeagueSeason.Item> getLeagueSeasons() throws ClashOfClansApiException {
//        return getLeagueSeasons(29000022L);
//    }
//
//     public List<LeagueSeason.Item> getLeagueSeasons(int limit) throws ClashOfClansApiException {
//         return getLeagueSeasons(29000022L, limit);
//     }
//
//    public LeagueSeason.Item getLeagueInfo(Long leagueId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("leagues/[id]".replace("[id]", leagueId.toString())), LeagueSeason.Item.class);
//    }
//
//    public List<WarLeague.Item> getWarLeagues() throws ClashOfClansApiException {
//        return GSON.fromJson(get("warleagues"), WarLeague.class).items;
//    }
//
//     public List<WarLeague.Item> getWarLeagues(int limit) throws ClashOfClansApiException {
//         return GSON.fromJson(get("warleagues?limit=[limit]".replace("[limit]", String.valueOf(limit))), WarLeague.class).items;
//     }
//
//    public WarLeague.Item getWarLeagueInfo(@NotNull Long warLeagueId) throws ClashOfClansApiException {
//        return GSON.fromJson(get("warleagues/[id]".replace("[id]", warLeagueId.toString())), WarLeague.Item.class);
//    }
//
    public ClanMembers getClanMembers(String clanTag) {
    	ObjectMapper objectMapper = new ObjectMapper();
    	ClanMembers ci = null;
		try {
			ci = objectMapper.readValue(get("clans/[tag]/members".replace("[tag]", formatTag(clanTag))), ClanMembers.class);
		} catch (JsonProcessingException | ClashOfClansApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ci;
    }

     public ClanMembers getClanMembers(String clanTag, int limit) throws ClashOfClansApiException {
     	ObjectMapper objectMapper = new ObjectMapper();
     	ClanMembers ci = null;
			try {
				ci = objectMapper.readValue(get("clans/[tag]/members?limit=[limit]"
				        .replace("[tag]", formatTag(clanTag))
				        .replace("[limit]", String.valueOf(limit))), ClanMembers.class);
			} catch (JsonProcessingException | ClashOfClansApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ci;
     }

     public ClanInfo getClanInfo(String clanTag) {
     	ObjectMapper objectMapper = new ObjectMapper();
     	ClanInfo ci = null;
 		try {
 			ci = objectMapper.readValue(get("clans/[tag]".replace("[tag]", formatTag(clanTag))), ClanInfo.class);
 		} catch (JsonProcessingException | ClashOfClansApiException e) {
 			e.printStackTrace();
 		}
         return ci;
     }

     public CurrentWar getCurrentWar(String clanTag) {
     	ObjectMapper objectMapper = new ObjectMapper();
     	CurrentWar ci = null;
 		try {
 			ci = objectMapper.readValue(get("clans/[tag]/currentwar".replace("[tag]", formatTag(clanTag))), CurrentWar.class);
 		} catch (JsonProcessingException | ClashOfClansApiException e) {
 			e.printStackTrace();
 		}
         return ci;
     }

     public WarLog getWarLog(String clanTag) {
     	ObjectMapper objectMapper = new ObjectMapper();
     	WarLog ci = null;
 		try {
 			ci = objectMapper.readValue(get("clans/[tag]/warlog".replace("[tag]", formatTag(clanTag))), WarLog.class);
 		} catch (JsonProcessingException | ClashOfClansApiException e) {
 			e.printStackTrace();
 		}
         return ci;
     }

     public CapitalRaidSeasons getCapitalRaidSeasons(String clanTag) {
     	ObjectMapper objectMapper = new ObjectMapper();
     	CapitalRaidSeasons ci = null;
 		try {
 			ci = objectMapper.readValue(get("clans/[tag]/capitalraidseasons".replace("[tag]", formatTag(clanTag))), CapitalRaidSeasons.class);
 		} catch (JsonProcessingException | ClashOfClansApiException e) {
 			e.printStackTrace();
 		}
         return ci;
     }

     public Player getPlayer(String clanTag) {
     	ObjectMapper objectMapper = new ObjectMapper();
     	Player ci = null;
 		try {
 			ci = objectMapper.readValue(get("players/[tag]".replace("[tag]", formatTag(clanTag))), Player.class);
 		} catch (JsonProcessingException | ClashOfClansApiException e) {
 			e.printStackTrace();
 		}
         return ci;
     }
}