package srl.nexum.demoimmobiliare.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import srl.nexum.demoimmobiliare.controller.ImmobileController;
import srl.nexum.demoimmobiliare.model.Immobile;
import srl.nexum.demoimmobiliare.model.ImmobileQuotation;
import srl.nexum.demoimmobiliare.repository.ImmobileRepository;
import srl.nexum.demoimmobiliare.vo.MlConfig;

import java.net.URI;
import java.util.List;

@Service("ImmobileServiceImpl")
public class ImmobileServiceImpl implements ImmobileService {

    private static final Logger logger = LogManager.getLogger(ImmobileController.class);

    @Autowired
    private ImmobileRepository immobileRepository;

    @Autowired
    private MlConfig mlConfig;

    @Override
    public List<Immobile> findAll() {
        logger.info("ImmobileServiceImpl->findAll");

        List<Immobile> immobili =immobileRepository.findAll();
        return immobili;
    }

    @Override
    public Immobile findById(String id) {
        return immobileRepository.findById(id).get();
    }

    @Override
    public void save(Immobile immobile) {
        immobileRepository.save(immobile);
    }

    @Override
    @Transactional
    public ImmobileQuotation searchAndSave(Immobile immobile) throws Exception{
        immobileRepository.save(immobile);

        //Chiamata al servizio ML e sostituire i valori fissi
        String srvUrl = mlConfig.getSrvUrl();
        URI url = new URI(srvUrl);
        RestTemplate restTemplate = new RestTemplate();

        //ImmobileQuotation immobileQuotation= new ImmobileQuotation();
        //immobileQuotation.setCprMin(new Double("75000.00").doubleValue());
        //immobileQuotation.setCprMax(new Double("125000.00").doubleValue());
        ImmobileQuotation immobileQuotation=restTemplate.postForObject(url, immobile, ImmobileQuotation.class);
        return immobileQuotation;
    }

    @Override
    public void delete(String id) {
        Immobile immobile = immobileRepository.findById(id).get();
        immobileRepository.delete(immobile);
    }
}
