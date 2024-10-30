package org.ebndrnk.newsystem.service;

import lombok.RequiredArgsConstructor;
import org.ebndrnk.newsystem.mapper.EntityMapper;
import org.ebndrnk.newsystem.model.dao.PatientProfile;
import org.ebndrnk.newsystem.model.dao.User;
import org.ebndrnk.newsystem.model.dto.PatientDTO;
import org.ebndrnk.newsystem.model.dto.UserDTO;
import org.ebndrnk.newsystem.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<PatientDTO> getAll(){
        return patientRepository.findAll().stream()
                .map(EntityMapper::mapToPatientDTO)
                .toList();
    }

    public List<PatientDTO>  saveAll(List<PatientDTO> patientDTOS){
        List<PatientProfile> patientProfiles = patientRepository.saveAll(patientDTOS.stream()
                .map(EntityMapper::mapToPatientProfile)
                .toList());

        return patientProfiles.stream()
                .map(EntityMapper::mapToPatientDTO)
                .toList();
    }

    public PatientDTO findByGUID(UUID guid){
        return EntityMapper.mapToPatientDTO(patientRepository.findByOldClientGuid(guid));
    }
}
