package net.sgoliver.android.actionbar;

import net.sgoliver.android.actionbar.R.id;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PlanetFragment extends Fragment {
	WebView myWebView;
	public static final String SELECTOR_DE_PANTALLAS = "pantallas";
	public static final int MUSICA = 0;
	public static final int FACEBOOK = 1;
	public static final int TWITTER = 2;
	public static final int VIDEOS = 3;
	public static final int RECITALES = 4;
	public static final int CHAT=5;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflate the layout for this fragment
		View view = inflater
				.inflate(R.layout.fragment_planet, container, false);
		myWebView = (WebView) view.findViewById(R.id.webview);
		// habilitamos javascript y el zoom
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setBuiltInZoomControls(true);
		// habilitamos los plugins (flash)
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
			myWebView.getSettings().setPluginState(PluginState.ON);
		} else {
			// IMPORTANTE!! este método ha sido eliminado en Android 4.3
			// por lo que si lo necesitamos para mantener la compatibilidad
			// hacia atrás hay que compilar el proyecto con Android 4.2 como
			// máximo
			myWebView.getSettings().setPluginState(PluginState.OFF);
		}
		int pantalla = getArguments().getInt(SELECTOR_DE_PANTALLAS);
		String myURL = "";
		switch (pantalla) {
		case MUSICA:
			myURL = "https://w.soundcloud.com/player/?url=http%3A%2F%2Fapi.soundcloud.com%2Fusers%2F2274858&amp;color=ff6600&amp;auto_play=false&amp";
			break;
		case FACEBOOK:
			myURL = "https://www.facebook.com/plugins/likebox.php?href=https%3A%2F%2Fwww.facebook.com%2Fmelianband&width=292&height=600&colorscheme=dark&show_faces=true&header=false&stream=true&show_border=false&appId=142985775838959";
			break;
		case TWITTER:
			myURL = "file:///android_asset/twitter.html";
			break;
		case VIDEOS:
			myURL = "file:///android_asset/youtube.html";
			break;
		case RECITALES:
			myURL = "http://www.fanrx.com/facebook/events.php?theme=zuck&page=melianband&bgcolor=ffffff&textcolor=000000&linkcolor=555555&max=5";
			break;
		case CHAT:
			myURL = "file:///android_asset/chat.html";
			break;
		}
		myWebView.setWebViewClient(new verMiWeb());
		myWebView.loadUrl(myURL);
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}
	private class verMiWeb extends WebViewClient {
	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        view.loadUrl(url);
	        return true;
	    }
	}
}
