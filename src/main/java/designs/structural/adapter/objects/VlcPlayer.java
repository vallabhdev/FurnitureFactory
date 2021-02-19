package designs.structural.adapter.objects;

public class VlcPlayer implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("playing on vlc player for file : " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //do nothing
    }
}
