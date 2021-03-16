package com.trackerms.controllers;

import com.trackerms.entity.ITrackableRepository;
import com.trackerms.models.Trackable;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.stream.Stream;

@CrossOrigin("*")
@RestController()
class TrackableResource {
    final private ITrackableRepository _trackableRepository;
    static final Logger logger = LoggerFactory.getLogger(TrackableResource.class);

    @Autowired
    private SimpMessagingTemplate _template;

    public TrackableResource(ITrackableRepository itemRepository) {
        this._trackableRepository = itemRepository;
        Stream.of( "Apples", "Oranges", "Carrots",
                            "Computers",
                  "Cars", "Planes", "Trains")
                .forEach(s->{this._trackableRepository.save(new Trackable(s));});
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Iterable<Trackable>> allRecords() {
        return Flux.fromStream(Stream.of(_trackableRepository.findAll()));
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Mono<Optional<Trackable>> allRecords(@PathVariable("id") long id) {
        Optional<Trackable> item = _trackableRepository.findById(id);
        item.ifPresent(trackable -> reportStatus("created", trackable));
        return Mono.just(item);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Mono<Trackable> createRecord(@RequestBody String recordDetails) {
        Trackable item = new Trackable( recordDetails);
        reportStatus("created", item);
        Trackable saved = _trackableRepository.save(item);
        return Mono.just(saved);
    }

    @RequestMapping(value = "/relay", method = RequestMethod.POST)
    public void relayMessage(@RequestBody String recordDetails) {
        Trackable item = new Trackable( recordDetails);
        reportStatus("relayed", item);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Mono<Trackable> updateRecord(@RequestBody Trackable recordDetails) {
        reportStatus("updated", recordDetails);
        return Mono.just(_trackableRepository.save(recordDetails));
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public Mono<Trackable> deleteRecord(@PathVariable("id") long id) {

        Optional<Trackable> item = _trackableRepository.findById(id);
        if(item.isPresent()) {
            _trackableRepository.deleteById(item.get().get_id());
            reportStatus("deleted", item.get());
        }
        return Mono.just(item.isPresent()?item.get():null);
    }

    private void reportStatus(String event, Trackable target) {

        JSONObject message = new JSONObject();
        try {
            message.put("event", event);
            message.put("payload", target.asJon());
            logger.info(event + " " + target.toString());
            _template.convertAndSend("/topic/message", message.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
