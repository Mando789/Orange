package com.example.demo.API.services;

import com.example.demo.API.model.Dials;
import com.example.demo.API.model.Groups;
import com.example.demo.API.repository.DialsRepository;
import com.example.demo.API.repository.GroupRepository;
import org.apache.catalina.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DialsService {

    private DialsRepository dialsRepo;
    private GroupRepository groupRepo;

    @Autowired
    public DialsService(DialsRepository dialsRepo, GroupRepository groupRepo) {
        this.dialsRepo = dialsRepo;
        this.groupRepo = groupRepo;
    }


    public boolean IsNew (Long msisdn){
        if(!dialsRepo.existsByMsisdn(msisdn)) {
            CreateUser(msisdn);
            return true;
        } else {
            return false;
        }

    }

    public void CreateUser(Long msisdn){
        Dials user = new Dials(msisdn);
        dialsRepo.save(user);

        Integer id = dialsRepo.getId(msisdn);

        if (id == 1 || id == 2 || id == 3)
        {
            // AggregateReference< Groups, Integer> group = AggregateReference.to(1);
            user.setGroupId(1);
            dialsRepo.save(user);

        } else if (id ==4 || id ==5 || id==6 || id==7 || id==8)
        {
            //AggregateReference< Groups, Integer> group = AggregateReference.to(2);
            user.setGroupId(2);
            dialsRepo.save(user);

        } else if (id==9 || id==10)
        {
            //AggregateReference< Groups, Integer> group = AggregateReference.to(3);
            user.setGroupId(3);
            dialsRepo.save(user);

        } else if (id==11) // group 4 no gift assigned
        {
            //AggregateReference< Groups, Integer> group = AggregateReference.to(4);
            user.setGroupId(4);
            dialsRepo.save(user);
        } else  //assigned (no group)
        {
            dialsRepo.save(user);
        }

    }

    public Boolean hasGroup(Long msisdn) {
        Optional<Dials> dialOpt= dialsRepo.findByMsisdn(msisdn);

        if( dialOpt.isPresent()){
            Dials dialUser = dialOpt.get();
            Integer gId = dialUser.getGroupId();
            return  (gId ==1 || gId ==2 || gId ==3 || gId==4);
        }

            return false;
    }

    public Boolean hasGift(Long msisdn) {
        Optional<Dials> dialOpt= dialsRepo.findByMsisdn(msisdn);

        if( dialOpt.isPresent()) {
            Dials dialUser = dialOpt.get();
            Integer gId = dialUser.getGroupId();
            return (gId != 4 || gId != null);
        }

        return false;
    }

    public boolean sameGift(Long msisdn, Integer id) {
        Optional<Dials> dialOpt= dialsRepo.findByMsisdn(msisdn);
        if (dialOpt.isPresent())
        {
            Integer gId = dialOpt.get().getGroupId();
            if (gId == null) {return false;}

            Optional<Groups> groupsOpt = groupRepo.findById(gId);
            if(groupsOpt.isPresent()){
                Groups group = groupsOpt.get();
                return group.getGiftId().equals(id);
            }
        }

        return false;

        }



    }
