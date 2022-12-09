package edu.global.ex.Command;

import edu.global.ex.Dao.MemberDao;
import edu.global.ex.Dto.MemberDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MemberListCommand implements MemberCommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        MemberDao dao = new MemberDao();
        List<MemberDto> dtoList = dao.list();

        request.setAttribute("list", dtoList);
    }
}
