package dev.tilegame.Audio;

//AudioPlayerManager este un proxy pentru audioPlayer
//functionalizatea adauga in plus calsei aduioPlayer este verificarea starii curente de play(daca deja se face play la un audio, opreste, apoi da play din nou)

public class AudioPlayerManager {

    private AudioPlayer myAudioPlayer;
    private boolean isPlayingSomething;

    public AudioPlayerManager(String path)
    {
        this.myAudioPlayer = new AudioPlayer(path);

    }
    public void playAudioLoop()
    {
        this.myAudioPlayer.loop_play();
        this.isPlayingSomething = true;
    }

    public void playNewAudio(String newAudio)
    {
        if(this.isPlayingSomething)
        {
            this.myAudioPlayer.stop();
            this.myAudioPlayer.setClip(newAudio);
            this.myAudioPlayer.loop_play();
            this.isPlayingSomething = true;
        }
        else
        {
            this.myAudioPlayer.setClip(newAudio);
            this.myAudioPlayer.loop_play();
            this.isPlayingSomething = true;
        }
    }
    public void stopAudio()
    {
        this.isPlayingSomething = false;
        this.myAudioPlayer.stop();
    }




}
