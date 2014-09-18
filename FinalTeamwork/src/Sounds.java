
import java.applet.Applet;
import java.applet.AudioClip;

public class Sounds {
	public static final AudioClip BALLWALL = Applet.newAudioClip(Sounds.class
			.getResource("hittingthewall.wav"));
	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sounds.class
			.getResource("gameoverq.wav"));
	public static final AudioClip BALLBRICK = Applet.newAudioClip(Sounds.class
			.getResource("hittingthebrick.wav"));
	public static final AudioClip WIN = Applet.newAudioClip(Sounds.class
			.getResource("Win.wav"));
//	public static final AudioClip BACK = Applet.newAudioClip(Sounds.class
//			.getResource("back.wav"));
}



