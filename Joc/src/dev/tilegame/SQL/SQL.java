package dev.tilegame.SQL;
import java.sql.*;

public class SQL {
    public static Connection c = null;
    public static Statement stmt = null;

    public static Integer level;
    public static Integer score;
    public static Integer hearts;
    public static Integer sound;
    public static Integer speed;
    public static String path;



    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:BazaDate.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS dateGame (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	level integer,\n"
                + "	score integer,\n"
                + "	hearts integer,\n"
                + "	sound integer,\n"
                + "	speed integer,\n"
                + "	path string \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insert(Integer level, Integer score, Integer hearts, Integer sound, Integer speed,String path) {
        String sql = "INSERT INTO dateGame(level, score, hearts, sound, speed, path) VALUES(?,?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,level);
            pstmt.setInt(2,score);
            pstmt.setInt(3,hearts);
            pstmt.setInt(4,sound);
            pstmt.setInt(5,speed);
            pstmt.setString(6,path);


            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void functieInitializare()
    {
        createNewTable();
        insert(1,0,10,0,1,"res/worlds/");

    }

    public static  Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:BazaDate.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void update() {

        //update este setat a.i sa updateze mereu linia cu id=1 cu datele statice din clasa SQL
        //deci oriunde in joc, doar se apeleaza setter de un camp, apoi update
        String sql = "UPDATE dateGame SET level = ? , "
                + "score = ?,"
                + "hearts = ?, "
                + "sound = ?, "
                + "speed = ?, "
                + "path = ? "
                + "WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, level);
            pstmt.setInt(2, score);
            pstmt.setInt(3, hearts);
            pstmt.setInt(4, sound);
            pstmt.setInt(5, speed);
            pstmt.setString(6, path);
            //id-ul este hardcoded setat pe 1
            pstmt.setInt(7, 1);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void selectAll() {
        //selectAll este si functie de iniatializare pentru variabilele statice din clasa SQL

        String sql = "SELECT id, level, score, hearts, sound ,speed, path FROM dateGame";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                level = rs.getInt("level");
                score = rs.getInt("score");
                hearts = rs.getInt("hearts");
                sound = rs.getInt("sound");
                speed = rs.getInt("speed");
                path = rs.getString("path");

                System.out.println(rs.getInt("id") + "\t" +
                        rs.getInt("level") + "\t" +
                        rs.getInt("score") + "\t" +
                        rs.getInt("hearts") + "\t" +
                        rs.getInt("sound") + "\t" +
                        rs.getInt("speed") + "\t" +
                        rs.getString("path"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static Integer getLevel() {
        return level;
    }

    public static Integer getScore() {
        return score;
    }

    public static Integer getHearts() {
        return hearts;
    }

    public static Integer getSound() {
        return sound;
    }

    public static Integer getSpeed() {
        return speed;
    }
    public static String getPath() {
        return path;
    }

    public static void setLevel(Integer level) {
        SQL.level = level;
    }

    public static void setScore(Integer score) {
        SQL.score = score;
    }

    public static void setHearts(Integer hearts) {
        SQL.hearts = hearts;
    }

    public static void setSound(Integer sound) {SQL.sound = sound;}

    public static void setSpeed(Integer speed) {
        SQL.speed = speed;
    }
    public static void setPath(String path) {
        SQL.path = path;
    }
}
