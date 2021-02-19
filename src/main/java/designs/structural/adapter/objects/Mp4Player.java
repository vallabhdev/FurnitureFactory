package designs.structural.adapter.objects;

public class Mp4Player implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("playing on mp4 player for file : " + fileName);
    }
}
