package com.tingkelai.sms;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.product.ProductApi;
import com.tingkelai.api.sms.SmsSendLogApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.product.Product;
import com.tingkelai.domain.sms.SmsSendLog;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.product.ProductVO;
import com.tingkelai.vo.sms.SmsSendLogVO;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 短信发送记录相关controller
 * 2018-12-17 11:42:39
 * @author liuzhengjie
 * @version 1.0
 */
@RestController
public class SmsSendLogController extends BaseCRUDController<SmsSendLog, Long> implements SmsSendLogApi<SmsSendLogVO> {

    @Override
    public ResponseMessage<List<SmsSendLogVO>> smsSendLogListGet(SmsSendLogVO smsSendLogVO, BasePage basePage) {
        return list(smsSendLogVO, basePage);
    }

    @Override
    public ResponseMessage<SmsSendLogVO> smsSendLogGet(SmsSendLogVO smsSendLogVO) {
        return getEntity(smsSendLogVO);
    }

    @Override
    public ResponseMessage<SmsSendLogVO> smsSendLogPost(@Valid SmsSendLogVO smsSendLogVO) {
        return saveEntity(smsSendLogVO);
    }

    @Override
    public ResponseMessage<SmsSendLogVO> smsSendLogPut(@Valid SmsSendLogVO smsSendLogVO) {
        return updateEntity(smsSendLogVO);
    }

    @Override
    public ResponseMessage<SmsSendLogVO> smsSendLogDelete(SmsSendLogVO smsSendLogVO) {
        return deleteEntity(smsSendLogVO);
    }
}
