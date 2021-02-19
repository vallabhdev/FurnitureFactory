package designs.structural.adapter;
//An Adapter Pattern says that just "converts the interface of a class into another interface that
// a client wants".
//In other words, to provide the interface according to client requirement while using the services of a class
// with a different interface.
//The Adapter Pattern is also known as Wrapper.

public class AdapterClient {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
