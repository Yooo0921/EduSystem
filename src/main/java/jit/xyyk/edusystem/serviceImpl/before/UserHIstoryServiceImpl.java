package jit.xyyk.edusystem.serviceImpl.before;

import jit.xyyk.edusystem.bean.History;
import jit.xyyk.edusystem.repository.before.UserHistoryRepository;
import jit.xyyk.edusystem.service.before.UserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Service
public class UserHIstoryServiceImpl implements UserHistoryService {

    @Autowired
    private UserHistoryRepository userHistoryRepository;
    @Override
    public int addHistory(int user_id, int course_id) {
        History history = new History();
        history.setCourse_id(course_id);
        history.setUser_id(user_id);
        history.setHistoryTime(new Timestamp(new Date().getTime()));

        return userHistoryRepository.insertHistory(history);
    }

    @Override
    public List<History> showHistory(int user_id) {
        return userHistoryRepository.showHistory(user_id);
    }

    @Override
    public int selectHistory(int user_id, int course_id) {
        return userHistoryRepository.selectHistory(user_id,course_id);
    }

    @Override
    public int updateHistory(int user_id, int course_id) {
        History history1 = new History();
        history1.setCourse_id(course_id);
        history1.setUser_id(user_id);
        history1.setHistoryTime(new Timestamp(new Date().getTime()));
        return userHistoryRepository.updateHistory(history1);
    }
}
