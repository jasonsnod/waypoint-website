BEGIN TRANSACTION;



INSERT INTO landmarks (landmark_name, landmark_address, landmark_details, landmark_longitude, landmark_latitude)
VALUES ('Cathedral Basilica of the Assumption',
        '1140 Madison Ave., Covington, KY, 41011',
        'Modeled after Notre Dame in Paris, the Gothic-style Cathedral Basilica of the Assumption on Madison Avenue features 26 Italian-carved gargoyle water spouts, flying buttresses, vaulted arches, columns and one of the world’s largest church stained-glass windows. A perfect substitute while the original Notre Dame is being rebuilt',
        '-84.50821238969064',
        '39.07830011540391');

INSERT INTO landmarks (landmark_name, landmark_address, landmark_details, landmark_longitude, landmark_latitude)
VALUES ('The Spaceship House',
        '222 Wright St., Covington, KY, 41011',
        'In the late 1960s and early 1970s, Finnish architect Matti Suuronen designed less than 100 Futuro houses, or flying saucer-esue homes — and Covington has one of them. It was purchased in 1973 by Rob Detzel, who first saw it in an issue of Family Circle. He made arrangements for its display at a home and garden show, then took it on a tour of sorts; in 1987, it landed (er, it was delivered) to its current location. The community embraces its presence and the Futuro House has even been included in a mural titled "Love the Cov" by Jarrod Becker, on the wall at Kroger’s Covington location. In 2013, Covington''s Mayor Sherry Carran declared Nov. 2 — the 40th anniversary to its purchase by Detzel — "Futuro House Day," officially naming the property it is on "Area 89." Note: This is a private residence.',
        '-84.52637788968997',
        '39.08834109344255');

INSERT INTO landmarks (landmark_name, landmark_address, landmark_details, landmark_longitude, landmark_latitude)
VALUES ('Cincinnati Museum Center at Union Terminal',
        '1301 Western Ave., Queensgate, OH, 45203',
        'The Cincinnati Museum Center is housed in Union Terminal, Cincinnati’s grand Art Deco masterpiece. A former train terminal, the space is an architectural wonder and houses the Museum of Natural History & Science, which features a recreated limestone cave; the Duke Energy Children’s Museum, consistently ranked in the top 10 children’s museums in the U.S.; the Cincinnati History Museum, which allows you to go back in time and climb aboard historical replicas of steamboats, buses and more; the Robert D. Lindner Family OMNIMAX Theater, which features a five-story domed screen; and the Nancy & David Wolf Holocaust & Humanity Center.',
        '-84.53724291852448',
        '39.1100648699855');

COMMIT TRANSACTION;