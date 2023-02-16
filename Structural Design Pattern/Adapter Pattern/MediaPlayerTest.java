interface MediaPlayer // Client_Interface
{
    public void play(String type, String filename);
}

class BasicMediaPlayer implements MediaPlayer // client method
{
    MediaAdpater ma1 = new MediaAdpater();

    public void play(String type, String filename) 
    {
        // if(type.equalsIgnoreCase("vlc"))
        // {
        //     System.out.println("Playing file :" + filename + " in VLC Media Player");
        // }

        // else
        // {
        //     System.out.println("*** Audio format not supported for :" + filename + " ***");
        // }
    
         ma1.play(type, filename);   
    }
}

class AdvancedMediaPlayer // adaptee 
{
    public void playMP3(String filename) 
    {
        System.out.println("Playing MP3 file : " + filename);    
    }

    public void playMP4(String filename) 
    {
        System.out.println("Playing MP4 file : " + filename);    
    }

    public void playAVI(String filename) 
    {
        System.out.println("Playing AVI file : " + filename);    
    }

    public void playWAV(String filename) 
    {
        System.out.println("Playing WAV file : " + filename);    
    }
}

class MediaAdpater implements MediaPlayer // adpater implements clinet_interface
{
    AdvancedMediaPlayer am1 = new AdvancedMediaPlayer(); // adaptee

    public void play(String type, String filename) 
       {
        if(type.equalsIgnoreCase("mp3"))
        {
            am1.playMP3(filename);
        }

        else if(type.equalsIgnoreCase("mp4"))
        {
            am1.playMP4(filename);
        }

        else if(type.equalsIgnoreCase("avi"))
        {
            am1.playAVI(filename);
        }

        else if(type.equalsIgnoreCase("wav"))
        {
            am1.playWAV(filename);
        }

        else
        {
            System.out.println("Unsupported file");
        }

    }
}

public class MediaPlayerTest
{
    public static void main(String[] args)  
    {
        MediaPlayer m1 = new BasicMediaPlayer();

        m1.play("vlc", "Music1.vlc");
        m1.play("mp3","m1.mp3");

        m1.play("mp4","video.mp4");
        
    }
}