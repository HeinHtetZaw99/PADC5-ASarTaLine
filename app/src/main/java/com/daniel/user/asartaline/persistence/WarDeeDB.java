package com.daniel.user.asartaline.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.daniel.user.asartaline.data.VOs.GeneralTasteVO;
import com.daniel.user.asartaline.data.VOs.MatchWarTeeVO;
import com.daniel.user.asartaline.data.VOs.MealShopVO;
import com.daniel.user.asartaline.data.VOs.ShopByDistanceVO;
import com.daniel.user.asartaline.data.VOs.ShopByPopularityVO;
import com.daniel.user.asartaline.data.VOs.SuitedForVO;
import com.daniel.user.asartaline.data.VOs.WarDeeVO;
import com.daniel.user.asartaline.persistence.daos.GeneralTasteDAO;
import com.daniel.user.asartaline.persistence.daos.MatchWarDeeDAO;
import com.daniel.user.asartaline.persistence.daos.MealShopDAO;
import com.daniel.user.asartaline.persistence.daos.ShopByDistanceDAO;
import com.daniel.user.asartaline.persistence.daos.ShopByPopularityDAO;
import com.daniel.user.asartaline.persistence.daos.SuitedForDAO;
import com.daniel.user.asartaline.persistence.daos.WarDeeDAO;

@Database(entities = {GeneralTasteVO.class, MatchWarTeeVO.class, MealShopVO.class,
        ShopByDistanceVO.class, ShopByPopularityVO.class, SuitedForVO.class, WarDeeVO.class},
        version = 1, exportSchema = false)
public abstract class WarDeeDB extends RoomDatabase {
    private static final String DB_NAME = "ASTL.DB";
    public static WarDeeDB INSTANCE;

    public static WarDeeDB getWarDeeDataBase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WarDeeDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract GeneralTasteDAO generalTasteDAO();

    public abstract MatchWarDeeDAO matchWarDeeDAO();

    public abstract MealShopDAO mealShopDAO();

    public abstract ShopByDistanceDAO shopByDistanceDAO();

    public abstract ShopByPopularityDAO shopByPopularityDAO();

    public abstract SuitedForDAO suitedForDAO();

    public abstract WarDeeDAO warDeeDAO();

}
