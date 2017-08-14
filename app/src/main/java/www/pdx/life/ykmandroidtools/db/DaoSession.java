package www.pdx.life.ykmandroidtools.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import www.pdx.life.ykmtools.bean.Student;
import www.pdx.life.ykmtools.bean.User;

import www.pdx.life.ykmandroidtools.db.StudentDao;
import www.pdx.life.ykmandroidtools.db.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig studentDaoConfig;
    private final DaoConfig userDaoConfig;

    private final StudentDao studentDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        studentDaoConfig = daoConfigMap.get(StudentDao.class).clone();
        studentDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        studentDao = new StudentDao(studentDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(Student.class, studentDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        studentDaoConfig.getIdentityScope().clear();
        userDaoConfig.getIdentityScope().clear();
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
