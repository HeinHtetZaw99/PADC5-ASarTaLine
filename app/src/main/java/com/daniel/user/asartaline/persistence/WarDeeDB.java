package com.daniel.user.asartaline.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.daniel.user.asartaline.data.VOs.GetShopList.ReviewsVO;
import com.daniel.user.asartaline.data.VOs.GetShopList.ShopVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.GeneralTasteVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.MatchWarTeeVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.MealShopVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.ShopByDistanceVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.ShopByPopularityVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.SuitedForVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.WarDeeVO;
import com.daniel.user.asartaline.persistence.daos.GeneralTasteDAO;
import com.daniel.user.asartaline.persistence.daos.MatchWarDeeDAO;
import com.daniel.user.asartaline.persistence.daos.MealShopDAO;
import com.daniel.user.asartaline.persistence.daos.ReviewsDAO;
import com.daniel.user.asartaline.persistence.daos.ShopByDistanceDAO;
import com.daniel.user.asartaline.persistence.daos.ShopByPopularityDAO;
import com.daniel.user.asartaline.persistence.daos.ShopDAO;
import com.daniel.user.asartaline.persistence.daos.SuitedForDAO;
import com.daniel.user.asartaline.persistence.daos.WarDeeDAO;

@Database(entities = {GeneralTasteVO.class, MatchWarTeeVO.class, MealShopVO.class,
        ShopByDistanceVO.class, ShopByPopularityVO.class, SuitedForVO.class, WarDeeVO.class, ShopVO.class, ReviewsVO.class},
        version = 3, exportSchema = false)
public abstract class WarDeeDB extends RoomDatabase {
    private static final String DB_NAME = "ASTL_DB";
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

    public abstract GeneralTasteDAO GeneralTasteDAO();

    public abstract MatchWarDeeDAO MatchWarDeeDAO();

    public abstract MealShopDAO MealShopDAO();

    public abstract ShopByDistanceDAO ShopByDistanceDAO();

    public abstract ShopByPopularityDAO ShopByPopularityDAO();

    public abstract SuitedForDAO SuitedForDAO();

    public abstract WarDeeDAO WarDeeDAO();

    public abstract ShopDAO ShopDAO();

    public abstract ReviewsDAO ReviewsDAO();

}
