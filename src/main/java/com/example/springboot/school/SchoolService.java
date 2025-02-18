package com.example.springboot.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository repository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository repository, SchoolMapper schoolMapper) {
        this.repository = repository;
        this.schoolMapper = schoolMapper;
    }


    public List<SchoolRespDto> findAll() {
        return repository.findAll()
                .stream()
                .map(schoolMapper::toSchoolRespDto)
                .collect(Collectors.toList());
    }

    public SchoolRespDto findOne(Integer id) {
        return repository.findById(id).map(schoolMapper::toSchoolRespDto).orElse(null);
    }

    public SchoolRespDto create(SchoolDto schoolDto) {
        var school = new School(schoolDto.name());
        var savedSchool =  repository.save(school);

        return schoolMapper.toSchoolRespDto(savedSchool);
    }
}
