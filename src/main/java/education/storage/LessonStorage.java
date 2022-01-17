package education.storage;

import education.model.Lesson;
import education.util.FileUtil;
import jdk.nashorn.internal.ir.IfNode;


import java.util.LinkedList;
import java.util.List;

public class LessonStorage {
    private List<Lesson> lessons = new LinkedList<>();


    public void add(Lesson lesson) {
        lessons.add(lesson);
        FileUtil.serializeLessons(lessons);
    }

    public void print() {
        for (Lesson lesson : lessons) {
            System.out.println(lesson);
        }
    }


    public void deleteLessonByName(String name) {
        lessons.removeIf(lesson -> lesson.getName().contains(name));
        FileUtil.serializeLessons(lessons);
    }

    public Lesson getByName(String name) {
        for (Lesson lesson : lessons) {
            if (lesson.getName().equals(name)) {
                return lesson;
            }
        }
        return null;
    }


    public void initData() {
        List<Lesson> lessonList = FileUtil.deserializeLessons();
        if (lessonList != null) {
            lessons = lessonList;
        }
    }
}
