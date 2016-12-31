package pkuhit.xap.file;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.sv.servlet.mvc.annotation.RequestAttribute;

public interface StorageService
{
    @RequestMapping(value = "/xapss", method = RequestMethod.PUT)
    void createBucket(@RequestAttribute("ownerId") String ownerId,
            @ModelAttribute("bucketName") String bucketName,
            @ModelAttribute StorageBucket bucket);

    StorageBucket[] listBuckets(String ownerId);

    ObjectMetadata[] listObjects(String ownerId, String bucketName);

    @RequestMapping(value = "/xapss/{bucketName}", method = RequestMethod.POST)
    void writeObject(@RequestAttribute("ownerId") String ownerId,
            @PathVariable("bucketName") String bucketName, ObjectData data);

    @RequestMapping(value = "/xapss/{bucketName}/{objectName}", method = RequestMethod.GET)
    StorageObject readObject(@RequestAttribute("ownerId") String ownerId,
            @PathVariable("bucketName") String bucketName,
            @PathVariable("objectName") String objectName);
}
