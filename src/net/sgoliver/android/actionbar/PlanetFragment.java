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

public class PlanetFragment extends Fragment {
	WebView myWebView;
	public static final String ARG_PLANET_NUMBER = null;

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
		myWebView.loadUrl("http://danielme.com");
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}
}
