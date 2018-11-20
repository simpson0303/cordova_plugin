//  cordova_plugin
//  Repo: https://github.com/simpson0303/cordova_plugin
package com.simpson0303.countdowndialog;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class CountDownDialog extends CordovaPlugin {
	public static Dialog dialog;
	public static int count = 0;
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if (action.equals("show")) {
			final String countTime = getOptionValue(args.getJSONObject(0),"countTime","10000");
			final String fontSize  =  getOptionValue(args.getJSONObject(0),"fontSize","300");
			final String fontColor =getOptionValue(args.getJSONObject(0),"fontColor","#00FF4D");
			final Boolean isCountStartFormOne =getOptionBooleanValue(args.getJSONObject(0),"isCountStartFormOne",false);
			final CordovaInterface cordova = this.cordova;
			Runnable runnable = new Runnable() {
				public void run() {
					if (dialog != null)
						dialog.hide();
					dialog = new Dialog(cordova.getActivity(), android.R.style.Theme_Light);
					dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
					int drawableDialogId, drawableLoaderTextId = 0;
					drawableDialogId = cordova.getActivity().getResources().getIdentifier("progress_dialog", "layout", cordova.getActivity().getPackageName());
					dialog.setContentView(drawableDialogId);
					drawableLoaderTextId = cordova.getActivity().getResources().getIdentifier("loaderTextView", "id", cordova.getActivity().getPackageName());
					Typeface face = Typeface.createFromAsset(cordova.getActivity().getAssets(),
							"www/plugins/cordova_plugin/www/digital-7.ttf");
					final TextView txtTitle = (TextView) dialog.findViewById(drawableLoaderTextId);
					if (txtTitle !=null) {
						txtTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,Integer.parseInt(fontSize));
						txtTitle.setTextColor(Color.parseColor(fontColor));
						txtTitle.setTypeface(face);
						count = isCountStartFormOne? 1 : 0;
						int	timeCount = Integer.parseInt(countTime) + 1000;
						new CountDownTimer(timeCount, 1000) {
							@Override
							public void onTick(long millisUntilFinished) {
								txtTitle.setText("" + count);
								count++;
							}
							@Override
							public void onFinish() {
								dialog.hide();
							}
						}.start();
						dialog.show();
					}
				}
			};
			this.cordova.getActivity().runOnUiThread(runnable);
		} else if (action.equals("hide")) {
			Runnable runnable = new Runnable() {
				public void run() {
					if(dialog!=null)
						dialog.hide();
				}
			};
			this.cordova.getActivity().runOnUiThread(runnable);
		}
		return true;
	}

 private String getOptionValue(JSONObject jsonObject,String key,String defaultValue)
 {
	 try {
		 return "null".equals(jsonObject.getString(key)) ? defaultValue : jsonObject.getString(key);
	 }
	 catch (JSONException e)
	 {
		 return defaultValue;
	 }
	 catch (Exception e)
	 {
		 return defaultValue;
	 }
}

	private Boolean getOptionBooleanValue(JSONObject jsonObject,String key,Boolean defaultValue)
	{
		try {
			return Boolean.parseBoolean(jsonObject.getString(key)) ? Boolean.parseBoolean(jsonObject.getString(key)) :defaultValue ;
		}
		catch (JSONException e)
		{
			return defaultValue;
		}
		catch (Exception e)
		{
			return defaultValue;
		}
	}
}
