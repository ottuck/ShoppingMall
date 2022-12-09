package edu.global.ex.Command;

import edu.global.ex.Dao.MemberDao;
import edu.global.ex.Dto.SalesDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MemberSalesCommand implements MemberCommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("MemberSalesCommand ..");

        MemberDao dao = new MemberDao();
        List<SalesDto> salesDtoList = dao.sales();

        request.setAttribute("salesList",salesDtoList);

    }
}
