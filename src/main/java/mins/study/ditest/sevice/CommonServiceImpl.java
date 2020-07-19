package mins.study.ditest.sevice;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommonServiceImpl implements CommonService {
    @Override
    public String makeRandomString() {
        return UUID.randomUUID().toString();
    }
}
