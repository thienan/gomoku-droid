/*
 *  Gomoku 4 Android
 *  https://github.com/makaw/gomoku-droid
 *  
 */
package pl.net.kaw.gomoku_droid.activities;


import java.util.concurrent.Callable;

import android.os.Bundle;
import pl.net.kaw.gomoku_droid.R;
import pl.net.kaw.gomoku_droid.activities.gui.BoardGraphics;
import pl.net.kaw.gomoku_droid.activities.gui.GameToolbar;
import pl.net.kaw.gomoku_droid.activities.gui.ModDialog;


/**
*
* Aktywność rozgrywki
* 
* @author Maciej Kawecki
* 
*/
public class GameActivity extends AppActivity {
	
	/** Pasek narzędziowy */
	private GameToolbar toolbar;
	/** Komponent planszy */
	private BoardGraphics boardGraphics;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
      super.onCreate(savedInstanceState);
      setContentView(R.layout.game_activity);
      
      boardGraphics = (BoardGraphics) findViewById(R.id.board);
      
      
      toolbar = new GameToolbar(this);
      toolbar.init();
      toolbar.startTimer();      
        
    }   
    
    
    public BoardGraphics getBoardGraphics() {
      return boardGraphics;
    }
    
    
    public GameToolbar getGameToolbar() {
      return toolbar;
    }
    
    
    /**
     * Zakończenie rozgrywki
     */
    public void endGame() {
    	
	  ModDialog.showConfirmDialog(this, getString(R.string.confirm_end_game), new Callable<Void>() {			
		  @Override
		  public Void call() {
		    GameActivity.this.finish();
		    return null;
		  }
		}
	  );	
    	
    }
    
    
    @Override
    public void onPause() {
      toolbar.pauseTimer();
      super.onPause();
    }
    
    @Override
    public void onResume() {
      toolbar.resumeTimer();
      super.onResume();
    }    
    
    
    @Override
    public void onBackPressed() {
    	
      endGame();	
    	
    }
    
    
    @Override
    public void onDestroy() {
    	
      toolbar.stopTimer();	
      super.onDestroy();	
      
    }
    
    
    
}
