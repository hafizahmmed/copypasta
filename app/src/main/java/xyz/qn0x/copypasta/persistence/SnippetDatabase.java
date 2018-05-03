package xyz.qn0x.copypasta.persistence;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import xyz.qn0x.copypasta.persistence.dao.SnippetDao;
import xyz.qn0x.copypasta.persistence.entities.Snippet;

@Database(entities = {Snippet.class}, version = 1, exportSchema = false)
public abstract class SnippetDatabase extends RoomDatabase {

    private static SnippetDatabase INSTANCE = null;

    public static SnippetDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SnippetDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SnippetDatabase.class, "word_database")
                            .addCallback(snippetDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    public abstract SnippetDao snippetDao();

    private static SnippetDatabase.Callback snippetDatabaseCallback = new SnippetDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

        }
    };
}
