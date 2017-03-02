//
// A FAIRE :
//- Classe Rdy

package apiTheMovieDB;

import java.awt.image.BufferedImage;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.*;
import javax.imageio.*;
//import java.io.File;

public class CineGoWebService {

	public static void main(String[] args) {
		String APIKey = "api_key=975c60bf70cb45fdc950f4d55f22cf3a";									//cle de l'API
		String URLImgVideo = "&append_to_response=videos,images";									//Option de l'API
		String[] listeIdFilms = {new String ("121856"),new String ("274870"),new String ("47971")};	//Recuperer la liste de tout les films à l'affiche dans la base de donnee
		List<CineGoFilm> tabFilms = new ArrayList<CineGoFilm>();									//Declaration d'un tableau de films


		//Get info for films from API
		for( int i = 0 ; i < listeIdFilms.length ; i++)
		{
			try {
				//Aller chercher les infos sur les films
				tabFilms.add(new CineGoFilm(listeIdFilms[i]));
				//URL TEST : https://api.themoviedb.org/3/movie/47971?api_key=975c60bf70cb45fdc950f4d55f22cf3a&append_to_response=videos,images
				URL TMDB = new URL("https://api.themoviedb.org/3/movie/"+tabFilms.get(i).getId()+"?"+APIKey+URLImgVideo);

				JsonReader reader = new JsonReader(new InputStreamReader(TMDB.openStream(), "UTF-8"));			
				Gson gson = new GsonBuilder().setLenient().serializeNulls().create();
				tabFilms.set(i, gson.fromJson(reader, CineGoFilm.class));

			}
			catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Verifier si connection OK");
			}
		}

		//Get .jpg for films from API
		for( int i = 0 ; i < tabFilms.size() ; i++){
			System.out.println(tabFilms.get(i));

			try{
				URL URLIMG = new URL ("https://image.tmdb.org/t/p/original"+tabFilms.get(i).getPoster_path());
				BufferedImage image = ImageIO.read(URLIMG);
				tabFilms.get(i).setDataIMG (image);
				//ImageIO.write(tabFilms.get(i).getDataIMG(), "jpg", new File("./"+tabFilms.get(i).getPoster_path()));
			}
			catch (Exception exImg) {
				exImg.printStackTrace();
				System.out.println("Verifier si connection OK");
			}
		}

	}
}


