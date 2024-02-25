package com.example.demo.API.services;

import com.example.demo.API.model.Dials;
import com.example.demo.API.model.HRedemption;
import com.example.demo.API.repository.DialsRepository;
import com.example.demo.API.repository.HRedemptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class HRedemptionService {

    private final DialsRepository dialsRepo;

    private  final HRedemptionRepository hRedemptionRepo;

    public HRedemptionService(DialsRepository dialsRepo, HRedemptionRepository hRedemptionRepo) {
        this.dialsRepo = dialsRepo;
        this.hRedemptionRepo = hRedemptionRepo;
    }

    public void redemptionLog(Long msisdn, Integer id) {

        Optional<Dials> dialOpt = dialsRepo.findByMsisdn(msisdn);

        if (dialOpt.isPresent()) {
            Dials dialUser = dialOpt.get();
            Integer groupId = dialUser.getGroupId();
            LocalDate date = LocalDate.now();

            HRedemption redemptionLog = new HRedemption(null,msisdn, id, groupId, date);

            hRedemptionRepo.save(redemptionLog);
        }
    }
}
