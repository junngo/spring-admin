package org.junngo.admin.domain.partner;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartnerRepositoryTest {

    @Autowired
    PartnerRepository partnerRepository;

    @Test
    public void create() {
        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "070-1111-2222";
        String partnerNumber = "010-1234-5678";
        String businessNumber = "1234567890123";
        String ceoName = "홍길동";
        Long categoryId = 1L;
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Partner partner = new Partner();
        partner.setName(name);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
//        partner.setCategoryId(categoryId);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);

        Partner newPartner = partnerRepository.save(partner);

        Assert.assertNotNull(newPartner);
        Assert.assertEquals(newPartner.getName(), name);
    }
}