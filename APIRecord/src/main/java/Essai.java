import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import api.ClashAPI;
import exception.AccessDeniedException;
import exception.ClashOfClansApiException;
import exception.ResourceNotFoundException;
import exception.ServiceTemprorarilyException;
import exception.UnknownErrorHappenedException;
import model.clan.CapitalRaidSeasons;
import model.clan.ClanInfo;
import model.clan.ClanMembers;
import model.clan.CurrentWar;
import model.clan.Player;
import model.clan.WarLog;

public class Essai {

	public static void main(String[] args) {
	    String API_KEY_ST_HILAIRE = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImJjZTU4YWI3LTAyYmEtNDNkNi04YWZiLTU2Njk1ZjNlYTYyYyIsImlhdCI6MTY2NTg2MzgyMiwic3ViIjoiZGV2ZWxvcGVyLzdmNmJkY2FjLTE4ZjctZjY4NS1hZjIzLWFlNjE4MzAzMzNiOSIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjg2LjIwMS4xOTAuMjExIl0sInR5cGUiOiJjbGllbnQifV19.lRCIcuW_JxhN1r0wacl4cc_NNOuOi2V6DK_wn3WuuESq7_IKZk9vSK_Uulru18VlNHJeOtXjWg8RIE8fD5VakA";
	    String API_KEY_CUBLAC     = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjBiZjMyOGVjLWNhM2MtNGQ2NS1iMDFlLTYwNGIxY2EyMTA3ZSIsImlhdCI6MTY2NjAzNjY0OCwic3ViIjoiZGV2ZWxvcGVyLzdmNmJkY2FjLTE4ZjctZjY4NS1hZjIzLWFlNjE4MzAzMzNiOSIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjkxLjE3NS40Ni43MCJdLCJ0eXBlIjoiY2xpZW50In1dfQ.KGxEut7zUwsnv9c0ql6TqlNcaczdAjjPsf7O4ckiVtWJDqRB8tO04RIbBcuSUL2pJ4ilvcZePjR8qEUKJ8uMPw";
	    String TAG_CLAN           = "#9VLV9VYL";
	    String TAG_PLAYER         = "#Y99RPVJVJ";
	    String token = API_KEY_CUBLAC;
	    
		ClashAPI api = new ClashAPI(token);
		ClanInfo ci = api.getClanInfo(TAG_CLAN);
		System.out.println(ci.getName());
		
		CurrentWar cw = api.getCurrentWar(TAG_CLAN);
		System.out.println(cw.getState());
		
		ClanMembers cm = api.getClanMembers(TAG_CLAN);
		System.out.println(cm.getItems().size());
		
		WarLog wl = api.getWarLog(TAG_CLAN);
		System.out.println(wl.getItems().get(0).getTeamSize());
		
		CapitalRaidSeasons crs = api.getCapitalRaidSeasons(TAG_CLAN);
		System.out.println(crs.getItems().get(0).getRaidsCompleted());
		
		Player pl = api.getPlayer(TAG_PLAYER);
		System.out.println(pl.getName());
	}

}
