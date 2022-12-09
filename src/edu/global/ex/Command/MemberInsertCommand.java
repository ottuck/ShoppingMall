package edu.global.ex.Command;

import edu.global.ex.Dao.MemberDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberInsertCommand implements MemberCommand {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("MemberInsertCommand ..");

        String custNo = request.getParameter("custNo");
        String custName = request.getParameter("custName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String joinDate = request.getParameter("joinDate");
        String grade = request.getParameter("grade");
        String city = request.getParameter("city");

        MemberDao dao = new MemberDao();
        dao.insert(custNo, custName, phone, address, joinDate, grade, city);

    }
}
