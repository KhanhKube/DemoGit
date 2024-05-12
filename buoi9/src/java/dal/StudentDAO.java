package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentDAO extends DBContext {

    //doc tat ca cac ban ghi tu StudentDB
    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        String sql = "select * from Student";
        //chay lenhj truy van
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getString("rollNo"), rs.getString("name"), rs.getFloat("mark"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    //insert
    public void insert(Student sd) {
        String sql = "insert into Student values(?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sd.getRollNo());
            st.setString(2, sd.getName());
            st.setFloat(3, sd.getMark());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    //delete
    public void delete(String id) {
        String sql = "DELETE FROM [dbo].[Student]\n"
                + "      WHERE RollNo = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void update(Student sd) {
        String sql = "update student set name = ? , mark = ? where rollNo = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sd.getName());
            st.setFloat(2, sd.getMark());
            st.setString(3, sd.getRollNo());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public Student getStudent(String rollNo) {
        String sql = "select * from student where rollNo = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, rollNo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Student student = new Student(rs.getString("rollNo"), rs.getString("name"), rs.getFloat("mark"));
                return student;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        StudentDAO sd = new StudentDAO();
        List<Student> li = sd.getAll();
        sd.delete(li.get(0).getRollNo());
        for (int i = 0; i < li.size(); i++) {
            System.out.println(li.get(i).getRollNo());
        }

    }

}
