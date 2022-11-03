import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import api.ClashAPI;
import exception.AccessDeniedException;
import exception.ClashOfClansApiException;
import exception.ResourceNotFoundException;
import exception.ServiceTemprorarilyException;
import exception.UnknownErrorHappenedException;
import model.clan.ClanInfo;

public class Essai {

	public static void main(String[] args) {
	    String API_KEY_ST_HILAIRE = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImJjZTU4YWI3LTAyYmEtNDNkNi04YWZiLTU2Njk1ZjNlYTYyYyIsImlhdCI6MTY2NTg2MzgyMiwic3ViIjoiZGV2ZWxvcGVyLzdmNmJkY2FjLTE4ZjctZjY4NS1hZjIzLWFlNjE4MzAzMzNiOSIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjg2LjIwMS4xOTAuMjExIl0sInR5cGUiOiJjbGllbnQifV19.lRCIcuW_JxhN1r0wacl4cc_NNOuOi2V6DK_wn3WuuESq7_IKZk9vSK_Uulru18VlNHJeOtXjWg8RIE8fD5VakA";
	    String API_KEY_CUBLAC     = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjBiZjMyOGVjLWNhM2MtNGQ2NS1iMDFlLTYwNGIxY2EyMTA3ZSIsImlhdCI6MTY2NjAzNjY0OCwic3ViIjoiZGV2ZWxvcGVyLzdmNmJkY2FjLTE4ZjctZjY4NS1hZjIzLWFlNjE4MzAzMzNiOSIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjkxLjE3NS40Ni43MCJdLCJ0eXBlIjoiY2xpZW50In1dfQ.KGxEut7zUwsnv9c0ql6TqlNcaczdAjjPsf7O4ckiVtWJDqRB8tO04RIbBcuSUL2pJ4ilvcZePjR8qEUKJ8uMPw";
	    String TAG_CLAN           = "#9VLV9VYL";
	    String token = API_KEY_ST_HILAIRE;
	    
	    try {
			ClashAPI api = new ClashAPI(token);
			try {
				ClanInfo ci = api.getClanInfo(TAG_CLAN);
				System.out.println(ci.getName());
		
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClashOfClansApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AccessDeniedException e) {
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
		}
	}

}
