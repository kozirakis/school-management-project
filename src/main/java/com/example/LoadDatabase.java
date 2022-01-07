package com.example;


import com.example.middlewear.entity.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LoadDatabase {


    private static String[] teacherNames = new String[] {
            "George",
            "Spyros",
            "Nikos",
            "Kostas",
            "Panagiotis"};

    private static String[] teacherLastNames = new String[] {
            "Bougias",
            "Kozirakis",
            "Kalimeris",
            "Papakostas",
            "Prokopiou",
            "Tsanos"
    };

    private static String[] addresses = new String[] {
            "Bironas",
            "Pireaus",
            "Monastiraki",
            "Kifisia",
            "Chalandri",
            "Ag. Paraskevi"
    };

    private static String[] phoneNumbers = new String[] {
            "6937486789",
            "6398771188",
            "6769171158",
            "6700163158",
            "6722335151",
            "6999932563"
    };

    private static String[] comments = new String[] {
            "Great Day !!",
            "Happy new year !!",
            "Good morning",
            "Good night",
            "Have a nice month",
            "Good job !!"
    };



//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//
//    @Bean
//    CommandLineRunner initDatabase(TeacherRepository teacherRepository) {
//        return args -> {
//            teacherRepository.deleteAll();
//            log.info("Preloading " + teacherRepository.saveAll(generateRandomTeachers()));
//        };
//    }

//    @Autowired
//    TeacherRepository teacherRepository;
//
//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void initDatabase() {
//        log.info("Preloading " + teacherRepository.saveAll(generateRandomTeachers()));
//    }

    private static int getRandomUpperBound(int i) {
        return new Random().nextInt(i);
    }

    public static List<Teacher> generateRandomTeachers() {
        int count = getRandomUpperBound(500);

        List<Teacher> teachers = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            teachers.add(
                    new Teacher(
                            teacherNames[getRandomUpperBound(teacherNames.length)],
                            teacherLastNames[getRandomUpperBound(teacherLastNames.length)],
                            addresses[getRandomUpperBound(addresses.length)],
                            phoneNumbers[getRandomUpperBound(addresses.length)],
                            comments[getRandomUpperBound(comments.length)]
                    )
            );

        }
        return teachers;
    }




}