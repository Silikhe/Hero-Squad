import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Squad {
    private static final ArrayList<Squad> mInstances = new ArrayList<Squad>();
    private static final ArrayList<Hero> mHeroes = new ArrayList<Hero>();
    //    private Hero mHero;
    private String mName;
    private String mCause;
    private final int mMaxSize;
    private final boolean mPublished;
    private final int id;
    private final LocalDateTime createdAt;
    private final List<Hero> squadHeroes = new ArrayList<>();

    public Squad(String name, String cause) {
        this.mName = name;
        this.mCause = cause;
        this.mMaxSize = 5;
        this.createdAt = LocalDateTime.now();
        this.mPublished = false;
        mInstances.add(this);
        this.id = mInstances.size();
    }

    public static ArrayList<Squad> getAll() {
        return mInstances;
    }

    public static void clearAllPosts() {
        mInstances.clear();
    }

    public static Squad findById(int id) {
        return mInstances.get(id - 1);
    }

    public List<Hero> getSquadHeroes() {
        return this.squadHeroes;
    }

    public List<Hero> getHeroes() {
        return mHeroes;
    }

    public void setHeroes(Hero hero) {
        mHeroes.add(hero);
    }

    public boolean getPublished() {
        return this.mPublished;
    }

    public boolean doesHeroExist(Hero hero) {
        int counter = 0;
        for (Hero mHero : mHeroes) {
            if (mHero.getName().equals(hero.getName())) {
                counter++;
            }
        }

        return counter != 1;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getCause() {
        return this.mCause;
    }

    public void setCause(String cause) {
        this.mCause = cause;
    }

    public boolean checkForMaximumMembers() {
        return mHeroes.size() <= this.mMaxSize;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
