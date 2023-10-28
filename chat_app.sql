

CREATE TABLE `account` (
  `ID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` text NOT NULL,
  `Fullname` varchar(255) DEFAULT NULL,
  `Gender` bit(1) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Status` bit(1) DEFAULT b'1',
  `Active` bit(1) DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `account` (`ID`, `Username`, `Password`, `Fullname`, `Gender`, `DOB`, `Status`, `Active`) VALUES
(1, 'admin', 'c4ca4238a0b923820dcc509a6f75849b', 'admin', b'0', '2002-11-12', b'0', b'1'),
(2, 'nam', 'c4ca4238a0b923820dcc509a6f75849b', 'Phan Xuan Hoai Nam', b'1', '2002-08-30', b'0', b'1'),
(3, 'sang', 'c4ca4238a0b923820dcc509a6f75849b', 'Sang', b'1', '2002-01-01', b'0', b'1'),
(4, 'pxhnam@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Phan Nam', b'1', '2002-11-12', b'0', b'1'),
(5, 'vietkhue@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Viet Khue', b'1', '2000-08-30', b'0', b'1'),
(6, 'tuntr@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Tuan Tran', b'1', '2023-01-01', b'0', b'1'),
(7, 'thuytien@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Thuy Tien', b'0', '2011-02-11', b'0', b'1'),
(8, 'thuytien1@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Thuy Tien 1', b'0', '2011-01-01', b'0', b'1'),
(9, 'nam1@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Nam 1', b'1', '2023-01-01', b'0', b'1'),
(10, 'nam2@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Nam 2', b'1', '2023-01-01', b'0', b'1'),
(11, 'nam3@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Nam 3', b'0', '2023-01-01', b'0', b'1'),
(12, 'nam3@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Nam 3', b'0', '2023-01-01', b'0', b'1'),
(13, 'nam4@gmail.com', 'e807f1fcf82d132f9bb018ca6738a19f', 'Nam 4', b'0', '2023-01-01', b'0', b'1'),
(14, 'nam5@gmail.com', '202cb962ac59075b964b07152d234b70', 'Nam 5', b'0', '2023-01-01', b'0', b'1'),
(15, 'nam6@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Nam 6', b'0', '2023-01-01', b'0', b'0'),
(16, 'nam10@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Nam 10', b'0', '2023-01-01', b'0', b'1');


CREATE TABLE `broadcast` (
  `id` int(11) NOT NULL,
  `message` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `broadcast` (`id`, `message`, `created_at`) VALUES
(1, 'Xin chào tất cả user', '2023-10-27 08:27:37'),
(2, 'rất chào!', '2023-10-27 10:00:55'),
(3, 'Thông báo!', '2023-10-28 13:31:47'),
(4, 'Hi!', '2023-10-28 13:32:35'),
(5, '???', '2023-10-28 13:32:40'),
(6, ':))', '2023-10-28 14:13:34');


CREATE TABLE `message` (
  `idTo` int(11) NOT NULL,
  `idFrom` int(11) NOT NULL,
  `message` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `message` (`idTo`, `idFrom`, `message`, `created_at`) VALUES
(1, 1, 'hi admin', '2023-10-27 08:27:08'),
(2, 2, 'hi nam', '2023-10-27 08:27:08'),
(2, 1, 'gi fen', '2023-10-27 08:27:08'),
(2, 3, 'ok', '2023-10-27 08:27:08'),
(2, 3, ':<', '2023-10-27 08:27:08'),
(3, 2, 'lam bai di', '2023-10-27 08:27:08'),
(2, 3, 'ok', '2023-10-27 08:27:08'),
(3, 2, 'ok hoai', '2023-10-27 08:27:08'),
(1, 3, 'hi admin', '2023-10-27 08:27:08'),
(3, 1, 'gi sang', '2023-10-27 08:27:08'),
(2, 1, 'alo', '2023-10-27 08:27:08'),
(1, 2, 'gi', '2023-10-27 08:27:08'),
(1, 2, 'hihi', '2023-10-27 08:27:08'),
(2, 1, 'test', '2023-10-27 08:27:08'),
(1, 2, 'test', '2023-10-27 08:27:08'),
(1, 2, 'alo', '2023-10-27 08:27:08'),
(2, 1, 'alo', '2023-10-27 08:27:08'),
(2, 3, 'alo', '2023-10-27 08:27:08'),
(1, 2, 'alo', '2023-10-27 08:27:08'),
(2, 3, 'alo', '2023-10-27 08:27:08'),
(2, 3, 'hi Nam', '2023-10-27 08:27:08'),
(2, 1, 'alo', '2023-10-27 08:27:08'),
(2, 3, 'alo', '2023-10-27 08:27:08'),
(1, 2, 'gi', '2023-10-27 08:27:08'),
(2, 3, 'alo', '2023-10-27 08:27:08'),
(2, 3, 'hihi', '2023-10-27 08:27:08'),
(3, 2, 'gi z', '2023-10-27 08:27:08'),
(3, 2, '???', '2023-10-27 08:27:08'),
(3, 2, 'dien ha', '2023-10-27 08:27:08'),
(3, 2, '=))', '2023-10-27 08:27:08'),
(2, 1, 'khong gi', '2023-10-27 08:27:08'),
(1, 2, '._.', '2023-10-27 08:27:08'),
(2, 1, 'hihi', '2023-10-27 08:27:08'),
(1, 2, '?', '2023-10-28 13:14:12');

ALTER TABLE `account`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `broadcast`
--
ALTER TABLE `broadcast`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `message`
  ADD KEY `idTo` (`idTo`),
  ADD KEY `idFrom` (`idFrom`);

ALTER TABLE `account`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

ALTER TABLE `broadcast`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`idTo`) REFERENCES `account` (`ID`),
  ADD CONSTRAINT `message_ibfk_2` FOREIGN KEY (`idFrom`) REFERENCES `account` (`ID`);
COMMIT;
