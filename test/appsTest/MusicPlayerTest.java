//package appsTest;
//
//import musicPlayer.MusicPlayer;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class MusicPlayerTest {
//    private MusicPlayer  mp = new MusicPlayer();
//    @BeforeEach
//    void testNewMusicPlayer(){
//
//        MusicPlayer  mp = new MusicPlayer();
//    }
//    @Test
//    void testThatMpCanPlaySong(){
//        assertFalse(mp.isPlayingSong());
//        mp.soundControl(1);
//    }
//    @Test
//    void testThatSongISNotPaying(){
//        assertFalse(mp.isPlayingSong());
//        mp.playSong();
//        assertTrue(mp.isPlayingSong());
//        mp.stopSong();
//        assertFalse(mp.isPlayingSong());
//    }
//
//}
