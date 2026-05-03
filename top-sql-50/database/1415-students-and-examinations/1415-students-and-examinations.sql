# Write your MySQL query statement below
Select st.student_id, st.student_name, sb.subject_name,Count(ex.student_id) as attended_exams
FROM Students as st CROSS JOIN Subjects as sb
LEft Join Examinations as ex
on ex.student_id = st.student_id AND ex.subject_name = sb.subject_name
Group by st.student_id,sb.subject_name
ORDER BY st.student_id, sb.subject_name;