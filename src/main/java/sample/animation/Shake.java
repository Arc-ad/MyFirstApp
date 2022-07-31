package sample.animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;


public class Shake {
    private TranslateTransition tt;
    public Shake(Node node){
        tt = new TranslateTransition(Duration.millis(70), node);
        tt.setFromX(0f);
        tt.setByX(10f);
        tt.setByY(23f);
        tt.setCycleCount(2);
        tt.setAutoReverse(true);

    }
    public void  playAnim(){
        tt.playFromStart();
    }
}
