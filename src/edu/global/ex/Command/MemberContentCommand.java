package edu.global.ex.Command;

import edu.global.ex.Dao.MemberDao;
import edu.global.ex.Dto.MemberDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberContentCommand implements MemberCommand{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String custNo = request.getParameter("custNo");

        MemberDao dao = new MemberDao();
        MemberDto dto = dao.content(custNo);

        request.setAttribute("content", dto);
    }
}
