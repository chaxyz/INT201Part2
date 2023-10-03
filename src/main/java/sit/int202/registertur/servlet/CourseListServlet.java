package sit.int202.registertur.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.registertur.models.CourseRegistered;
import sit.int202.registertur.models.CourseRepository;
import sit.int202.registertur.models.Semester;
import sit.int202.registertur.models.Subject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CourseListServlet", value = "/course-list")
public class CourseListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        if (sc.getAttribute("semesters") == null) {
            sc.setAttribute("semesters", Semester.getAllSemesterText());
        }

        getServletContext().getRequestDispatcher("/course_list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        request.setCharacterEncoding("UTF-8");
        if (parameterMap.get("semester") == null) {
            doGet(request, response);
            return;
        }
        int semester = Integer.valueOf(parameterMap.get("semester")[0]);
//            request.setAttribute("semesters", Semester.getAllSemesterText());
        request.setAttribute("selectedSemester", semester);
        request.setAttribute("subjects", CourseRepository.getSubjects(semester));
        Map<String, Boolean> semesterSubjecs = new HashMap();
        HttpSession session = request.getSession(false);
        if (session != null) {
            CourseRegistered cr = (CourseRegistered) session.getAttribute("courseRegistered");
            if (cr != null) {
                getRegisteredSubject(semester, cr, semesterSubjecs);
            }
        }
        request.setAttribute("semesterSubjects",semesterSubjecs);
        getServletContext().getRequestDispatcher("/course_list.jsp").forward(request, response);
    }

    private void getRegisteredSubject(int semester, CourseRegistered courseRegister, Map<String, Boolean> map) {
        if (courseRegister.getRegisteredCourse(semester) != null) {
            for (Subject subject : courseRegister.getRegisteredCourse(semester)) {
                map.put(subject.getSubjectId(), true);
            }
        }
    }
}
