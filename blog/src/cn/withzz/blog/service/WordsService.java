package cn.withzz.blog.service;

import cn.withzz.blog.dao.UserDao;
import cn.withzz.blog.dao.WordsDao;
import cn.withzz.blog.pojos.User;
import cn.withzz.blog.pojos.Words;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by shmily_zz on 2017/3/23.
 */
@Service
public class WordsService {
    @Resource(name = "wordsDao")
    private WordsDao wordsDao;

    public List<Words> getAllWords(){
        return wordsDao.findAll();
    }
    public boolean  publishWords(Words words){
        words.setDate(new Date());
        return wordsDao.add(words)==null? false:true;
    }
    public void deleteWords(Words words){
        wordsDao.delete(words);
    }

    public void setWordsDao(WordsDao wordsDao) {
        this.wordsDao = wordsDao;
    }
}
