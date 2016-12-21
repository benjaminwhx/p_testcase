package com.jd.bt.powermock;

import org.mockito.Matchers;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.powermock.api.mockito.PowerMockito.*;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.support.membermodification.MemberMatcher.field;

/**
 * User: 吴海旭
 * Date: 2016-12-21
 * Time: 下午6:51
 */
// 这里加载spring的配置文件，用来加载一些配置，再下面注入使用
@ContextConfiguration("classpath:spring-test.xml")
// 这里写准备stub的类
@PrepareForTest
public class SpringWithPowerMockTest extends SpringBaseTest {

//    @Autowired
//    private BizQueryRpc bizQueryRpc;
//    @Autowired
//    private MerchantBizConfigService merchantBizConfigService;
//    @Autowired
//    private UserApplyRpc userApplyRpc;
//    @Autowired
//    private BtRpc btRpc;
//    @Autowired
//    private BtplusOverdueRpc btplusOverdueRpc;
//    @Autowired
//    private JrDataRpc jrDataRpc;
//    @Autowired
//    protected BtFrontRpc btFrontRpc;
//    @Autowired
//    private DataCrashService dataCrashServiceJsf;
//    @Autowired
//    private UserTaskRpc userTaskRpc;
//    @Autowired
//    private BusinessStepLogRpc businessStepLogRpc;
//    @Autowired
//    private BaitiaoRealnameResourceRpc baitiaoQuickPayResourceRpc;
//    @Autowired
//    private CreditDecisionService creditDecisionService;
//    @Autowired
//    private UserRegisterResource userRegisterResource;
//    @Autowired
//    private BizOrderService bizOrderService;
//
//    protected Order getOrderByOrderId(String orderId) {
//        return bizQueryRpc.selectOne(orderId);
//    }
//
//    protected void autowiredField(LoanDecisionHuiBaoYang spy) throws IllegalAccessException {
//        field(LoanDecisionBaoYangImpl.class, "merchantBizConfigService").set(spy, merchantBizConfigService);
//        field(LoanDecisionBaoYangImpl.class, "userApplyRpc").set(spy, userApplyRpc);
//        field(LoanDecisionBaoYangImpl.class, "btRpc").set(spy, btRpc);
//        field(LoanDecisionBaoYangImpl.class, "btplusOverdueRpc").set(spy, btplusOverdueRpc);
//        field(LoanDecisionBaoYangImpl.class, "jrDataRpc").set(spy, jrDataRpc);
//        field(LoanDecisionBaoYangImpl.class, "btFrontRpc").set(spy, btFrontRpc);
//        // 注入小贷撞数接口
//        LoanMobileCrashServiceImpl loanMobileCrashService = mock(LoanMobileCrashServiceImpl.class);
//        when(loanMobileCrashService.getCrashSuccessCount(Matchers.anyObject())).thenCallRealMethod();
//        field(LoanMobileCrashServiceImpl.class, "dataCrashServiceJsf").set(loanMobileCrashService, dataCrashServiceJsf);
//        field(LoanDecisionBaoYangImpl.class, "loanMobileCrashService").set(spy, loanMobileCrashService);
//        field(LoanDecisionBaoYangImpl.class, "userTaskRpc").set(spy, userTaskRpc);
//        field(LoanDecisionBaoYangImpl.class, "businessStepLogRpc").set(spy, businessStepLogRpc);
//        field(LoanDecisionBaoYangImpl.class, "baitiaoQuickPayResourceRpc").set(spy, baitiaoQuickPayResourceRpc);
//        // mock掉日志
//        mockStatic(RdpLogWriter.class);
//        // 注入cds
//        CdsV2SFYRpc cdsV2SFYRpc = spy(new CdsV2SFYRpc());
//        field(CdsV2SFYRpc.class, "creditDecisionService").set(cdsV2SFYRpc, creditDecisionService);
//        field(LoanDecisionBaoYangImpl.class, "cdsV2SFYRpc").set(spy, cdsV2SFYRpc);
//        // 开户
//        UserRegisterRpc userRegisterRpc = spy(new UserRegisterRpc());
//        field(UserRegisterRpc.class, "userRegisterResource").set(userRegisterRpc, userRegisterResource);
//        field(LoanDecisionBaoYangImpl.class, "userRegisterRpc").set(spy, userRegisterRpc);
//        // 更新order
//        BizOrderRpc bizOrderRpc = spy(new BizOrderRpc());
//        field(BizOrderRpc.class, "bizOrderService").set(bizOrderRpc, bizOrderService);
//        field(LoanDecisionBaoYangImpl.class, "bizOrderRpc").set(spy, bizOrderRpc);
//    }
}
