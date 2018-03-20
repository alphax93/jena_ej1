package ejerciciojena1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class EjercicioJena1 {

    OkHttpClient client = new OkHttpClient();
    static String urlDatos = "https://opendata.aemet.es/opendata/sh/8d9e14e4";
    
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\Entrar\\keystore.jks");
        EjercicioJena1 example = new EjercicioJena1();
        String response = example.getResponse("https://opendata.aemet.es/opendata/api/valores/climatologicos/inventarioestaciones/todasestaciones/?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhaXRvci5nYXJjaWExMDFAYWx1LnVscGdjLmVzIiwianRpIjoiNDE1NDQxNWEtMDE3NC00YTNjLThiZDYtZmRjNWRiYzMyZGI1IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE1MjE0NTYxNTksInVzZXJJZCI6IjQxNTQ0MTVhLTAxNzQtNGEzYy04YmQ2LWZkYzVkYmMzMmRiNSIsInJvbGUiOiIifQ.iDtSB9Lx4abkKDqWfJxQKpVjD-Xg-oDi_KyxLDMlQR0");
        System.out.println(response);
        
        String responseDatos = example.getResponse(urlDatos);
        System.out.println(responseDatos);
        
        
        
    }
    
    public String getResponse(String url){
        

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("cache-control", "no-cache")
                .build();

        try (Response response = client.newCall(request).execute()){
            return response.body().string();
        } catch (IOException ex) {
            Logger.getLogger(EjercicioJena1.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

}
