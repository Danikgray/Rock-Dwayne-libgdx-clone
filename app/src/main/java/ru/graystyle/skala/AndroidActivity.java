package ru.graystyle.skala;
import com.badlogic.gdx.backends.android.AndroidApplication;
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import android.view.Window;
import android.view.WindowManager;
 

public class AndroidActivity extends AndroidApplication{ 
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);
       AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new Game(), config);
        
    }
	
} 
