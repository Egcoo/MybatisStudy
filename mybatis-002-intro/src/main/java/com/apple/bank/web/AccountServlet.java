package com.apple.bank.web;

import com.apple.bank.exception.MoneyNotEnoughException;
import com.apple.bank.exception.transferException;
import com.apple.bank.service.impl.AccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2023/4/28 - 14:19
 * <p>
 * servlet实际上是不处理业务的
 */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(AccountServlet.class);
    private AccountServiceImpl accountService = new AccountServiceImpl();

    public AccountServlet() throws IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 获取表单数据
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));

        // 获取输出的日志信息
        logger.info("Executing transfer method with fromActno: {}, toActno: {}, money: {}", fromActno, toActno, money);

        // 调用service的方法完成转账，(调业务层)
        try {
            accountService.transfer(fromActno, toActno, money);

        } catch (MoneyNotEnoughException e) {
            response.sendRedirect(request.getContextPath() + "/error1.html");
        } catch (transferException e) {
            response.sendRedirect(request.getContextPath() + "/error1.html");
        }
        //调用view 完成展示结果
        response.sendRedirect(request.getContextPath() + "/success.html");

    }
}
