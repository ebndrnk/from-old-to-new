package org.ebndrnk.newsystem.service;

import lombok.RequiredArgsConstructor;
import org.ebndrnk.newsystem.mapper.EntityMapper;
import org.ebndrnk.newsystem.model.dao.PatientNote;
import org.ebndrnk.newsystem.model.dao.PatientProfile;
import org.ebndrnk.newsystem.model.dto.PatientDTO;
import org.ebndrnk.newsystem.model.dto.PatientNoteDTO;
import org.ebndrnk.newsystem.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<PatientNoteDTO> saveAll(List<PatientNoteDTO> patientNoteDTOS){
        List<PatientNote> patientNotes = noteRepository.saveAll(patientNoteDTOS.stream()
                .map(EntityMapper::mapToPatientNote)
                .toList());

        return patientNotes.stream()
                .map(EntityMapper::mapToPatientNoteDTO)
                .toList();
    }
}
