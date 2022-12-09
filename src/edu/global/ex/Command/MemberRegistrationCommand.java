package edu.global.ex.Command;

import edu.global.ex.Dao.MemberDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberRegistrationCommand implements MemberCommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("MemberRegistrationCommand ..");

        MemberDao dao = new MemberDao();
        String custNo = dao.max_custNo();

        request.setAttribute("custNo", custNo);
    }
}
