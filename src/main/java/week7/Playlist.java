public class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }

    public void addSong(String title) {
        if (count < songs.length) {
            songs[count] = title;
            count++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[count];
        System.arraycopy(songs, 0, copy, 0, count);
        return copy;
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("Original playlist first song: " + p.getSongs()[0]);
        System.out.println("Modified copy first song: " + copy[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}