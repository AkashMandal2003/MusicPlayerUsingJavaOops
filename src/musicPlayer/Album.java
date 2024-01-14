package musicPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;

    private ArrayList<Song> songs;

    public Album() {
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public Song findSong(String title) {
        for (Song checkedSong : songs) {
            if (checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    //Return true if song successfully added otherwise false
    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            System.out.println(title + ", Successfully added to the list.");
            return true;
        } else {
            System.out.println("Song with name " + title + " already exist in the list.");
            return false;
        }
    }


    //we need to add song to playlist, and it should present in the songs arrList then only we can add to our playlist
    public boolean addToPlayList(int tractNo, LinkedList<Song> PlayList) {
        int index = tractNo - 1;
        if (index > 0 && index <= this.songs.size()) {
            PlayList.add(this.songs.get(index));
            System.out.println("Added to the playlist.");
            return true;
        }
        System.out.println("This album does not have the song with this track number " + tractNo + ".");
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> PlayList) {
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                PlayList.add(checkedSong);
                System.out.println("Added to the playlist.");
                return true;
            }
        }
        System.out.println(title + ", there is no song on this name.");
        return false;
    }
}
